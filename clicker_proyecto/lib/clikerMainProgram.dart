// ignore_for_file: file_names, unnecessary_new, unused_local_variable, prefer_const_constructors, deprecated_member_use, avoid_print, non_constant_identifier_names, use_key_in_widget_constructors

import 'dart:async';

import 'package:flutter/material.dart';

import 'conexionClicker.dart';
import 'mainMenu.dart';

class clickerMainProgram extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<clickerMainProgram> {
  String username = "";
  String password = "";

  //upgrade1
  int score = 0;
  int click = 1;
  int click_cost = 10;
  int upgrade1n = 0;

  //timer1
  int upgrade2n = 0;
  int upgrade2Cost = 100;

  //timer2
  int upgrade3n = 0;
  int upgrade3Cost = 200;
  //timer3
  int upgrade4n = 0;
  int upgrade4Cost = 400;
  //timer4
  int upgrade5n = 0;
  int upgrade5Cost = 600;

  String endGameText = "CLICK PIKACHU";

  void load() {
    final user = ModalRoute.of(context)!.settings.arguments as User;
    setState(() {
      username = user.username;
      password = user.password;
      score = user.score;
      click = user.click;
      click_cost = user.click_cost;
      upgrade1n = user.upgrade1n;
      upgrade2n = user.upgrade2n;
      upgrade2Cost = user.upgrade2Cost;
      upgrade3n = user.upgrade3n;
      upgrade3Cost = user.upgrade3Cost;
      upgrade4n = user.upgrade4n;
      upgrade4Cost = user.upgrade4Cost;
      upgrade5n = user.upgrade5n;
      upgrade5Cost = user.upgrade5Cost;
    });

    for (int i = 0; i < upgrade2n; i++) {
      const oneSec = const Duration(milliseconds: 1000);
      Timer _timer = new Timer.periodic(
        oneSec,
        (Timer timer) {
          if (resetState == true) {
            setState(() {
              timer.cancel();
            });
          } else {
            setState(() {
              score++;
            });
          }
        },
      );
    }

    for (int i = 0; i < upgrade3n; i++) {
      const oneSec1 = const Duration(milliseconds: 500);
      Timer _timer1 = new Timer.periodic(
        oneSec1,
        (Timer timer) {
          if (resetState == true) {
            setState(() {
              timer.cancel();
            });
          } else {
            setState(() {
              score++;
            });
          }
        },
      );
    }

    for (int i = 0; i < upgrade4n; i++) {
      const oneSec2 = const Duration(milliseconds: 300);
      Timer _timer2 = new Timer.periodic(
        oneSec2,
        (Timer timer) {
          if (resetState == true) {
            setState(() {
              timer.cancel();
            });
          } else {
            setState(() {
              score++;
            });
          }
        },
      );
    }

    for (int i = 0; i < upgrade5n; i++) {
      const oneSec3 = const Duration(milliseconds: 150);
      Timer _timer3 = new Timer.periodic(
        oneSec3,
        (Timer timer) {
          if (resetState == true) {
            setState(() {
              timer.cancel();
            });
          } else {
            setState(() {
              score++;
            });
          }
        },
      );
    }
  }

  void SAVE() {
    setState(() {});
    final user = ModalRoute.of(context)!.settings.arguments as User;
    username = user.username;
    password = user.password;
    user.score = score;
    user.click = click;
    user.click_cost = click_cost;
    user.upgrade1n = upgrade1n;
    user.upgrade2n = upgrade2n;
    user.upgrade2Cost = upgrade2Cost;
    user.upgrade3n = upgrade3n;
    user.upgrade3Cost = upgrade3Cost;
    user.upgrade4n = upgrade4n;
    user.upgrade4Cost = upgrade4Cost;
    user.upgrade5n = upgrade5n;
    user.upgrade5Cost = upgrade5Cost;
  }

  void _incrementCounter() {
    setState(() {
      score = score + click;
    });
  }

  void upgrade1() {
    setState(() {
      if (score >= click_cost) {
        canMej++;
        if (canMej >= 5) {
          setState(() {
            disponible = "disponible";
          });
        } else {
          setState(() {
            disponible = "bloqueado";
          });
        }

        score = score - click_cost;
        click = click * 2;
        click_cost = click_cost * 2;
        upgrade1n++;
      } else {}
    });
  }

  void upgrade2() {
    const oneSec = const Duration(milliseconds: 1000);
    int _start = 10;
    setState(() {
      if (score >= upgrade2Cost) {
        canMej++;
        if (canMej >= 5) {
          setState(() {
            disponible = "disponible";
          });
        } else {
          setState(() {
            disponible = "bloqueado";
          });
        }
        score = score - upgrade2Cost;
        upgrade2Cost = upgrade2Cost * 2;
        upgrade2n++;
        Timer _timer = new Timer.periodic(
          oneSec,
          (Timer timer) {
            if (resetState == true) {
              setState(() {
                timer.cancel();
              });
              resetState = false;
            } else {
              setState(() {
                score++;
              });
            }
          },
        );
      }
    });
  }

  void upgrade3() {
    const oneSec = const Duration(milliseconds: 500);
    int _start = 10;
    setState(() {
      if (score >= upgrade3Cost) {
        canMej++;
        if (canMej >= 5) {
          setState(() {
            disponible = "disponible";
          });
        } else {
          setState(() {
            disponible = "bloqueado";
          });
        }
        score = score - upgrade3Cost;
        upgrade3Cost = upgrade3Cost * 2;
        upgrade3n++;
        Timer _timer = new Timer.periodic(
          oneSec,
          (Timer timer) {
            if (resetState == true) {
              setState(() {
                timer.cancel();
              });
              resetState = false;
            } else {
              setState(() {
                score++;
              });
            }
          },
        );
      }
    });
  }

  void upgrade4() {
    const oneSec = const Duration(milliseconds: 300);
    int _start = 10;
    setState(() {
      if (score >= upgrade4Cost) {
        canMej++;
        if (canMej >= 5) {
          setState(() {
            disponible = "disponible";
          });
        } else {
          setState(() {
            disponible = "bloqueado";
          });
        }
        score = score - upgrade4Cost;
        upgrade4Cost = upgrade4Cost * 2;
        upgrade4n++;
        Timer _timer = new Timer.periodic(
          oneSec,
          (Timer timer) {
            if (resetState == true) {
              setState(() {
                timer.cancel();
              });
              resetState = false;
            } else {
              setState(() {
                score = score + 10;
              });
            }
          },
        );
      }
    });
  }

  void upgrade5() {
    const oneSec = const Duration(milliseconds: 150);
    int _start = 10;
    setState(() {
      if (score >= upgrade5Cost) {
        canMej++;
        if (canMej >= 5) {
          setState(() {
            disponible = "disponible";
          });
        } else {
          setState(() {
            disponible = "bloqueado";
          });
        }
        score = score - upgrade5Cost;
        upgrade5Cost = upgrade5Cost * 2;
        upgrade5n++;
        Timer _timer = new Timer.periodic(
          oneSec,
          (Timer timer) {
            if (resetState == true) {
              setState(() {
                timer.cancel();
              });
              resetState = false;
            } else {
              setState(() {
                score = score + 15;
              });
            }
          },
        );
      }
    });
  }

//
//
//Este es el metodo del examen
//          |||
//          VVV
  String disponible = "bloqueado";
  int suma = 0;
  int canMej = 0;
  void mejora1examen() {
    if (canMej >= 5) {
      setState(() {
        suma = suma + 50;
        score = score + suma;
        canMej = 0;
        disponible = "bloqueado";
      });
    }
  }

  bool resetState = false;
  void reset() {
    setState(() {
      resetState = true;
      score = 0;
      click = 1;
      click_cost = 10;

      upgrade1n = 0;

      //timer1
      upgrade2n = 0;
      upgrade2Cost = 100;

      //timer2
      upgrade3n = 0;
      upgrade3Cost = 200;
      //timer3
      upgrade4n = 0;
      upgrade4Cost = 400;
      //timer4
      upgrade5n = 0;
      upgrade5Cost = 600;

      disponible = "bloqueado";
      suma = 0;
      canMej = 0;
    });
  }

  void resetreset() {
    if (resetState == true) {
      resetState = false;
    }
  }

  @override
  Widget build(BuildContext context) {
    final user = ModalRoute.of(context)!.settings.arguments as User;
    username = user.username;
    password = user.password;
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.yellowAccent,
        centerTitle: true,
        title: Text('PIKACHU',
            style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 40,
                color: Colors.black)),
      ),
      body: Container(
        decoration: BoxDecoration(color: Colors.yellow),
        child: SingleChildScrollView(
          child: Column(
            // mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              //Image(
              // image: AssetImage('assets/pikachu.png'),
              // ),

              Row(mainAxisAlignment: MainAxisAlignment.center, children: [
                IconButton(
                  iconSize: 150,
                  onPressed: _incrementCounter,
                  icon: Image(
                    image: AssetImage('assets/pikachu.png'),
                  ),
                  //icon: Icon(
                  //  Icons.catching_pokemon_sharp,
                  //  size: 100,
                  // ),
                  tooltip: 'pulsar',
                ),
              ]),

              Text(
                '$score',
                //style: Theme.of(context).textTheme.headline4,
                style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 40,
                    color: Colors.black),
              ),
              // FloatingActionButton(
              //   child: const Icon(
              //     Icons.person,
              //     size: 100,
              //   ),
              //   onPressed: _incrementCounter,
              //   tooltip: 'Increment',
              // ),
              Text(
                endGameText,
                style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 30,
                    color: Colors.black),
              ),
              SizedBox(
                height: 5,
              ),

              RaisedButton(
                disabledColor: Colors.yellowAccent,
                child: Text(
                  "Multiplier Click \n cost: " +
                      '$click_cost' +
                      " inventory: " +
                      '$upgrade1n',
                  textAlign: TextAlign.center,
                ),
                splashColor: Colors.black,
                color: Colors.yellowAccent,
                onPressed: () {
                  upgrade1();
                },
              ),
              SizedBox(
                height: 5,
              ),
              RaisedButton(
                disabledColor: Colors.amber,
                child: Text(
                  "Farm of pokemon \n cost: " +
                      '$upgrade2Cost' +
                      " inventory: " +
                      '$upgrade2n',
                  textAlign: TextAlign.center,
                ),
                splashColor: Colors.black,
                color: Colors.yellowAccent,
                onPressed: () {
                  upgrade2();
                },
              ),
              SizedBox(
                height: 5,
              ),
              RaisedButton(
                disabledColor: Colors.yellowAccent,
                child: Text(
                  "Farm but better \n cost: " +
                      '$upgrade3Cost' +
                      " inventory: " +
                      '$upgrade3n',
                  textAlign: TextAlign.center,
                ),
                splashColor: Colors.black,
                color: Colors.yellowAccent,
                onPressed: () {
                  upgrade3();
                },
              ),

              SizedBox(
                height: 5,
              ),
              RaisedButton(
                disabledColor: Colors.yellowAccent,
                child: Text(
                  "Farm but even better \n cost: " +
                      '$upgrade4Cost' +
                      " inventory: " +
                      '$upgrade4n',
                  textAlign: TextAlign.center,
                ),
                splashColor: Colors.black,
                color: Colors.yellowAccent,
                onPressed: () {
                  upgrade4();
                },
              ),
              SizedBox(
                height: 5,
              ),
              RaisedButton(
                disabledColor: Colors.yellowAccent,
                child: Text(
                  "Farm, the greatest \n cost: " +
                      '$upgrade5Cost' +
                      " inventory: " +
                      '$upgrade5n',
                  textAlign: TextAlign.center,
                ),
                splashColor: Colors.black,
                color: Colors.yellowAccent,
                onPressed: () {
                  upgrade5();
                },
              ),
              SizedBox(
                height: 5,
              ),

              RaisedButton(
                disabledColor: Colors.yellowAccent,
                child: Text(
                  "mejora examen " + disponible,
                  textAlign: TextAlign.center,
                ),
                splashColor: Colors.black,
                color: Colors.yellowAccent,
                onPressed: () {
                  mejora1examen();
                },
              ),

              Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: [
                RaisedButton(
                  disabledColor: Colors.yellowAccent,
                  child: Text(
                    "RESET",
                    textAlign: TextAlign.center,
                  ),
                  splashColor: Colors.black,
                  color: Colors.red,
                  onPressed: () {
                    reset();
                  },
                ),
                RaisedButton(
                  disabledColor: Colors.yellowAccent,
                  child: Text(
                    "SAVE",
                    textAlign: TextAlign.center,
                  ),
                  splashColor: Colors.black,
                  color: Colors.red,
                  onPressed: () {
                    SAVE();
                    save(context);
                  },
                ),
                RaisedButton(
                    disabledColor: Colors.yellowAccent,
                    child: Text(
                      "LOAD",
                      textAlign: TextAlign.center,
                    ),
                    splashColor: Colors.black,
                    color: Colors.red,
                    onPressed: () {
                      load();
                    }),
              ]),
            ],
          ),
        ),
      ),
    );
  }

  void save(BuildContext context) async {
    //comprueba que la validacion ha sido correcta

    User user = new User(
        username,
        password,
        score,
        click,
        click_cost,
        upgrade1n,
        upgrade2n,
        upgrade2Cost,
        upgrade3n,
        upgrade3Cost,
        upgrade4n,
        upgrade4Cost,
        upgrade5n,
        upgrade5Cost);

    ConnectionUser con = new ConnectionUser();
    bool reg = await con.addcontent(user);
  }
}
