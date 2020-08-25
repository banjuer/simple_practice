package xyz.banjuer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author banju
 */
public class SqliteHelper {

    private final String path;

    private static final Map<String, SqliteHelper> INSTANCE_MAP = new ConcurrentHashMap<>();

    private SqliteHelper(String db) {
        path = this.getClass().getResource("/") + db;
    }

    public static SqliteHelper getDefaultInstance() {
        return getInstance("paxos.db");
    }

    public static SqliteHelper getInstance(String db) {
        if (INSTANCE_MAP.get(db) == null) {
            synchronized (SqliteHelper.class) {
                if (INSTANCE_MAP.get(db) == null) INSTANCE_MAP.put(db, new SqliteHelper(db));
            }
        }
        return INSTANCE_MAP.get(db);
    }

    public void query(String sql, Object[] params, CallBack callBack) {
        ResultSet rs = null;
        try (
                Connection conn = getConn();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            setParams(ps, params);
            rs = ps.executeQuery();
            callBack.process(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public int update(String sql, Object[] params) {
        try (
                Connection conn = getConn();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            setParams(ps, params);
            conn.setAutoCommit(false);
            int rows = ps.executeUpdate();
            conn.commit();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Connection getConn() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("获取连接失败");
    }

    private static void setParams(PreparedStatement ps, Object[] params) throws SQLException {
        if (params == null || params.length == 0)
            return;
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }

    public interface CallBack {
        void process(ResultSet rs) throws Exception;
    }


    public static void main(String[] args) {
        SqliteHelper.getDefaultInstance().query("select * from config", null, rs -> {
            while (rs.next()) {
                System.out.println(rs.getObject(2));
            }
        });
    }

}