// ignore_for_file: use_key_in_widget_constructors

import 'package:clicker_proyecto/register.dart';
import 'package:flutter/material.dart';
import 'package:clicker_proyecto/mainMenu.dart';

import 'clikerMainProgram.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'prueba',
      initialRoute: "/mainMenu",
      routes: {
        '/mainMenu': (BuildContext context) => mainMenu(),
        '/register': (BuildContext context) => Registro(),
        '/clikerMainProgram': (BuildContext context) => clickerMainProgram(),
      },
    );
  }
}
