// ignore_for_file: file_names, unnecessary_new

import 'package:mysql1/mysql1.dart';

import '../mainMenu.dart';

class ConnectionUser {
  Future login(String usuario, String pass) async {
    // Open a connection (testdb should already exist)
    final conn = await MySqlConnection.connect(ConnectionSettings(
        host: '10.0.2.2', port: 3306, user: 'root', db: 'clickerproyecto'));

    // Query again database using a parameterized query
    String sql = "select * from user where username = '" +
        usuario +
        "' and password = '" +
        pass +
        "'";

    var results2 = await conn.query(sql);
    var user = new User("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    for (var row in results2) {
      user = new User(row[0], row[1], row[3], row[4], row[5], row[6], row[7],
          row[8], row[9], row[10], row[11], row[12], row[13], row[14]);
    }

    // Finally, close the connection
    await conn.close();

    return user;
  }

  Future<bool> register(User user) async {
    // Open a connection (testdb should already exist)
    final conn = await MySqlConnection.connect(ConnectionSettings(
        host: '10.0.2.2', port: 3306, user: 'root', db: 'clickerproyecto'));

    bool comprobar = false;

    var result = await conn.query(
        'insert into user (username, password) values (?, ?)',
        [user.username, user.password]);

    comprobar = true;

    // Finally, close the connection
    await conn.close();

    return comprobar;
  }

  Future<bool> addcontent(User user) async {
// Open a connection (testdb should already exist)
    final conn = await MySqlConnection.connect(ConnectionSettings(
        host: '10.0.2.2', port: 3306, user: 'root', db: 'clickerproyecto'));

    bool comprobar = false;

    var result = await conn.query(
        'UPDATE user SET score = ?, click = ?, click_cost = ?, upgrade1n = ?, upgrade2n = ?, upgrade2Cost = ?, upgrade3n = ?, upgrade3Cost = ?,  upgrade4n = ?,  upgrade4Cost = ?,  upgrade5n = ?,  upgrade5Cost = ? WHERE username = ? and password = ?;',
        [
          user.score,
          user.click,
          user.click_cost,
          user.upgrade1n,
          user.upgrade2n,
          user.upgrade2Cost,
          user.upgrade3n,
          user.upgrade3Cost,
          user.upgrade4n,
          user.upgrade4Cost,
          user.upgrade5n,
          user.upgrade5Cost,
          user.username,
          user.password,
        ]);

    comprobar = true;

    // Finally, close the connection
    await conn.close();

    return comprobar;
  }
}
