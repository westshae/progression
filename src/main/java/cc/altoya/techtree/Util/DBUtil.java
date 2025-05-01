package cc.altoya.techtree.Util;

import java.sql.*;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;

import cc.altoya.techtree.Experience.Experience;

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
                "pickaxe_experience INTEGER DEFAULT 0, " +
                "axe_experience INTEGER DEFAULT 0, " +
                "shovel_experience INTEGER DEFAULT 0, " +
                "hoe_experience INTEGER DEFAULT 0, " +
                "melee_experience INTEGER DEFAULT 0, " +
                "ranged_experience INTEGER DEFAULT 0, " +
                "armour_experience INTEGER DEFAULT 0, " +
                "fishing_experience INTEGER DEFAULT 0);";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    // Add or Update player experience by UUID
    public static void updatePlayerExperience(UUID uuid, int pickaxeExperience, int axeExperience, int shovelExperience,
            int hoeExperience, int meleeExperience, int rangedExperience, int armourExperience, int fishingExperience) throws SQLException {
        Connection conn = loadDatabase();
        String sql = "INSERT OR REPLACE INTO players (uuid, pickaxe_experience, axe_experience, shovel_experience, hoe_experience, melee_experience, ranged_experience, armour_experience, fishing_experience) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uuid.toString());
            pstmt.setInt(2, pickaxeExperience);
            pstmt.setInt(3, axeExperience);
            pstmt.setInt(4, shovelExperience);
            pstmt.setInt(5, hoeExperience);
            pstmt.setInt(6, meleeExperience);
            pstmt.setInt(7, rangedExperience);
            pstmt.setInt(8, armourExperience);
            pstmt.setInt(9, fishingExperience);

            pstmt.executeUpdate();
        }
    }

    // Get player experience by UUID
    public static HashMap<Experience, Integer> getPlayerExperience(UUID uuid) throws SQLException {
        Connection conn = loadDatabase();
        String sql = "SELECT pickaxe_experience, axe_experience, shovel_experience, hoe_experience, melee_experience, ranged_experience, armour_experience, fishing_experience FROM players WHERE uuid = ?";
        
        HashMap<Experience, Integer> experienceMap = new HashMap<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uuid.toString());
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                experienceMap.put(Experience.PICKAXE, rs.getInt("pickaxe_experience"));
                experienceMap.put(Experience.AXE, rs.getInt("axe_experience"));
                experienceMap.put(Experience.SHOVEL, rs.getInt("shovel_experience"));
                experienceMap.put(Experience.HOE, rs.getInt("hoe_experience"));
                experienceMap.put(Experience.MELEE, rs.getInt("melee_experience"));
                experienceMap.put(Experience.RANGED, rs.getInt("ranged_experience"));
                experienceMap.put(Experience.ARMOUR, rs.getInt("armour_experience"));
                experienceMap.put(Experience.FISHING, rs.getInt("fishing_experience"));
            }
            return experienceMap;
        } catch (Exception e) {
            return null;
        }
    }
}
