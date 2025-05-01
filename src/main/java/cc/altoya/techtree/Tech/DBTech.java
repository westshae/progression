package cc.altoya.techtree.Tech;

import java.sql.*;
import java.io.File;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

import org.bukkit.Bukkit;

public class DBTech {
  public static void initialize() {
    try {
      loadDatabase();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Load the database and return a Connection object
  private static Connection loadDatabase() throws SQLException {
    try {
      File dataFolder = Bukkit.getServer().getPluginManager().getPlugin("techtree").getDataFolder();

      if (!dataFolder.exists()) {
        dataFolder.mkdirs();
      }
      File dbFile = new File(dataFolder, "techtree.db");
      String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
      Connection conn = DriverManager.getConnection(url);
      initializeTechTable(conn);
      return conn;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  // Create table if it does not exist
  private static void initializeTechTable(Connection conn) throws SQLException {
    System.out.println("Initializing tech table");
    String sql = "CREATE TABLE IF NOT EXISTS techs (" +
        "uuid TEXT PRIMARY KEY, " +
        "tech_name TEXT, " +
        "tech_level INTEGER DEFAULT 0);";
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(sql);
    }
  }

  public static void updateTechLevel(UUID uuid, String techName, int techLevel) throws SQLException {
    Connection conn = loadDatabase();
    String sql = "INSERT OR REPLACE INTO techs (uuid, tech_name, tech_level) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, uuid.toString());
      pstmt.setString(2, techName);
      pstmt.setInt(3, techLevel);
      pstmt.executeUpdate();
    }
  } 

  public static int getTechLevel(UUID uuid, String techName) throws SQLException {
    Connection conn = loadDatabase();
    String sql = "SELECT tech_level FROM techs WHERE uuid = ? AND tech_name = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, uuid.toString());
      pstmt.setString(2, techName);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return rs.getInt("tech_level");
      }
    }
    return 0;
  }

  public static Map<UUID, Integer> getAllBreakStoneTechLevels() throws SQLException {
    Map<UUID, Integer> techLevels = new HashMap<>();
    Connection conn = loadDatabase();
    String sql = "SELECT uuid, tech_level FROM techs WHERE tech_name = 'break_stone'";
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        UUID uuid = UUID.fromString(rs.getString("uuid"));
        int techLevel = rs.getInt("tech_level");
        techLevels.put(uuid, techLevel);
      }
    }
    return techLevels;
  }
}
