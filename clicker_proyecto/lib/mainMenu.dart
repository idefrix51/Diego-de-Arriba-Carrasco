// ignore: file_names

// ignore_for_file: camel_case_types, file_names, prefer_const_constructors, deprecated_member_use

import 'package:clicker_proyecto/clikerMainProgram.dart';
import 'package:clicker_proyecto/conexionClicker.dart';
import 'package:clicker_proyecto/register.dart';
import 'package:flutter/material.dart';

class mainMenu extends StatefulWidget {
  mainMenu({Key? key}) : super(key: key);

  @override
  MyHomePageState createState() => MyHomePageState();
}

class MyHomePageState extends State<mainMenu> {
  // This widget is the root of your application.

  String username = '';
  String password = '';
  String mensajeError = "";

  final formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.yellow,
        appBar: AppBar(
          backgroundColor: Colors.yellowAccent,
          centerTitle: true,
          title: Text('PIKACHU CLICKER',
              style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 40,
                  color: Colors.black)),
        ),
        body: Center(
          child: Padding(
              padding: EdgeInsets.all(50),
              child: Form(
                  key: formKey,
                  child: Column(
                    children: [
                      Icon(
                        Icons.catching_pokemon,
                        size: 100,
                      ),
                      TextFormField(
                        decoration: InputDecoration(labelText: 'UserName'),
                        onSaved: (value) {
                          username = value!;
                        },
                        validator: (value) {
                          if (value!.isEmpty) {
                            return "Campo nombre vacío";
                          }
                        },
                      ),
                      TextFormField(
                        decoration: InputDecoration(labelText: 'Password'),
                        onSaved: (value) {
                          password = value!;
                        },
                        validator: (value) {
                          if (value!.isEmpty) {
                            return "Campo apellido vacío";
                          }
                          if (value.length < 3) {
                            return "Campo no válido";
                          }
                        },
                        obscureText: true,
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      if (mensajeError.isNotEmpty)
                        Text(
                          mensajeError,
                          style: TextStyle(
                              color: Colors.red, fontWeight: FontWeight.bold),
                          textAlign: TextAlign.center,
                        ),
                      SizedBox(
                        height: 30,
                      ),
                      // ignore: deprecated_member_use
                      RaisedButton(
                        child: Text("Iniciar sesión",
                            style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 15,
                                color: Colors.black)),
                        color: Colors.red,
                        onPressed: () {
                          mainMenu(context);
                        },
                      ),

                      SizedBox(
                        height: 20,
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text('No estas registrado'),
                          FlatButton(
                              color: Colors.red,
                              textColor: Theme.of(context).primaryColor,
                              onPressed: () {
                                showRegister(context);
                              },
                              child: Text('Registrarse',
                                  style: TextStyle(
                                      fontWeight: FontWeight.bold,
                                      fontSize: 15,
                                      color: Colors.black)))
                        ],
                      )
                    ],
                  ))),
        ));
  }

  void mainMenu(BuildContext context) async {
    //comprueba que la validacion ha sido correcta
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      ConnectionUser con = new ConnectionUser();
      User user = await con.login(username, password);
      // User user = new User();

      if (user.username != '') {
        Navigator.of(context).pushNamed('/clikerMainProgram', arguments: user);
      } else {
        setState(() {
          mensajeError = "Usuario o contraseña incorrectos";
        });
      }
    }
  }

  void showRegister(BuildContext context) {
    Navigator.of(context).pushNamed('/register');
  }
}

class User {
  String username;
  String password;

  int score;
  int click;

  int click_cost;
  int upgrade1n;

  //timer1
  int upgrade2n;
  int upgrade2Cost;

  //timer2
  int upgrade3n;
  int upgrade3Cost;
  //timer3
  int upgrade4n;
  int upgrade4Cost;
  //timer4
  int upgrade5n;
  int upgrade5Cost;

  User(
      this.username,
      this.password,
      this.score,
      this.click,
      this.click_cost,
      this.upgrade1n,
      this.upgrade2n,
      this.upgrade2Cost,
      this.upgrade3n,
      this.upgrade3Cost,
      this.upgrade4n,
      this.upgrade4Cost,
      this.upgrade5n,
      this.upgrade5Cost);
}
