package dao;

import java.sql.*;

public class OracleConnection {
    private Connection cn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public OracleConnection() {
    }

    public Connection getConnection() {
        try {
            //1,加载驱动
            Class.forName("oracle.jdbc.OracleDriver");
            // 创建连接对象
            this.cn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:yj", "yj", "123456");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return this.cn;
        }
    }

    public ResultSet getResultSet(String sql, Object[] parameters) {
        this.getConnection();

        try {
            this.pstmt = this.cn.prepareStatement(sql);
            if (parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    this.pstmt.setObject(i + 1, parameters[i]);
                }
            }

            this.rs = this.pstmt.executeQuery();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return this.rs;
    }

    public boolean execute(String sql, Object[] parameters) {
        boolean isSuccess = false;
        this.getConnection();
        try {
            this.pstmt = this.cn.prepareStatement(sql);
            if (parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    this.pstmt.setObject(i + 1, parameters[i]);
                }
            }
            this.pstmt.executeUpdate();
            isSuccess = true;
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return isSuccess;
    }

    public Object getScalar(String sql, Object[] parameters) {
        Object value = null;
        if (this.cn == null) {
            this.getConnection();
        }

        try {
            this.pstmt = this.cn.prepareStatement(sql);
            if (parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    this.pstmt.setObject(i + 1, parameters[i]);
                }
            }

            this.rs = this.pstmt.executeQuery();
            if (this.rs.next()) {
                value = this.rs.getObject(1);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return value;
    }
}

