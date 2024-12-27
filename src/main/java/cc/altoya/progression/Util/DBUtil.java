package cc.altoya.progression.Util;

import java.sql.*;
import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;

public class DBUtil {
    // Load the database and return a Connection object
    private static Connection loadDatabase() throws SQLException {
        try {
            File dataFolder = Bukkit.getServer().getPluginManager().getPlugin("progression").getDataFolder();

            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }
            File dbFile = new File(dataFolder, "experience.db");
            String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
            Connection conn = DriverManager.getConnection(url);
            createTableIfNotExists(conn);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Create table if it does not exist
    private static void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS players (" +
                "uuid TEXT PRIMARY KEY, " +
                "experience INTEGER DEFAULT 0);";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    // Add or Update player experience by UUID
    public static void updatePlayerExperience(UUID uuid, int experience) throws SQLException {
        Connection conn = loadDatabase();
        String sql = "INSERT OR REPLACE INTO players (uuid, experience) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uuid.toString());
            pstmt.setInt(2, experience);
            pstmt.executeUpdate();
        }
    }

    // Get player experience by UUID
    public static Integer getPlayerExperience(UUID uuid) throws SQLException {
        Connection conn = loadDatabase();
        String sql = "SELECT experience FROM players WHERE uuid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uuid.toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("experience");
            }
        }
        return null; // Return null if player not found
    }

}
