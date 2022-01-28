// ignore_for_file: unnecessary_new, prefer_const_constructors

import 'package:flutter/material.dart';
import 'clikerMainProgram.dart';
import 'package:clicker_proyecto/mainMenu.dart';
import 'conexionClicker.dart';

class Registro extends StatefulWidget {
  Registro({Key? key}) : super(key: key);

  @override
  MyHomePageState createState() => MyHomePageState();
}

class MyHomePageState extends State<Registro> {
  String username = '';
  String password = '';
  String mensajeError = "";

//para que nos permita recoger datos del formulario
  final formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.yellow,
        appBar: AppBar(
          title: Text(
            'Registro',
            style: TextStyle(
                fontWeight: FontWeight.bold, fontSize: 40, color: Colors.black),
          ),
          centerTitle: true,
          backgroundColor: Colors.yellowAccent,
        ),
        body: Center(
          child: SingleChildScrollView(
            child: Padding(
                padding: EdgeInsets.all(50),
                child: Form(
                    key: formKey,
                    child: Column(
                      children: [
                        Icon(
                          Icons.supervised_user_circle,
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
                              return "Campo contraseña vacío";
                            }
                            if (value.length < 3) {
                              return "Campo no válido";
                            }
                          },
                          obscureText: true,
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
                          color: Colors.red,
                          child: Text("Registrar",
                              style: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  fontSize: 15,
                                  color: Colors.black)),
                          onPressed: () {
                            register(context);
                          },
                        ),
                      ],
                    ))),
          ),
        ));
  }

  void register(BuildContext context) async {
    //comprueba que la validacion ha sido correcta
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      User user = new User(
          username, password, 0, 1, 10, 0, 0, 100, 0, 200, 0, 400, 0, 600);

      ConnectionUser con = new ConnectionUser();
      bool reg = await con.register(user);

      if (reg) {
        Navigator.of(context).pushNamed('/mainMenu');
      } else {
        setState(() {
          mensajeError = "No se pudo guardar el usuario";
        });
      }
    }
  }

  void showRegister(BuildContext context) {
    Navigator.of(context).pushNamed('/register');
  }
}
