import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Login Page',
      theme: ThemeData(
        primarySwatch: Colors.orange,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  bool _obscureText = true;

  @override
  Widget build(BuildContext context) {
    Size deviceSize = MediaQuery.of(context).size;
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            height: deviceSize.height,
            width: deviceSize.width,
            decoration: BoxDecoration(
              gradient: LinearGradient(
                begin: Alignment.centerLeft,
                end: Alignment.centerRight,
                colors: [
                  Colors.orange[900]!,
                  Colors.orange[800]!,
                ],
              ),
            ),
            child: Column(
              children: <Widget>[
                SizedBox(
                  height: deviceSize.height / 10,
                ),
                Row(
                  children: [
                    SizedBox(
                      width: deviceSize.width / 20,
                    ),
                    Text(
                      "Login",
                      style: TextStyle(
                        fontSize: 44,
                        fontFamily: 'Arial',
                        color: Colors.white,
                      ),
                    ),
                  ],
                ),
                Row(
                  children: [
                    SizedBox(
                      width: deviceSize.width / 20,
                      height: deviceSize.height / 20,
                    ),
                    Text(
                      "Welcome Back",
                      style: TextStyle(
                        fontSize: 24,
                        fontFamily: 'Arial',
                        color: Colors.white,
                      ),
                    ),
                  ],
                ),
                SizedBox(
                  height: deviceSize.height / 30,
                ),
                Align(
                  alignment: Alignment.bottomCenter,
                  child: Container(
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.only(
                        topLeft: const Radius.circular(60.0),
                        topRight: const Radius.circular(60.0),
                      ),
                    ),
                    height: deviceSize.height * 0.74,
                    child: Column(
                      children: <Widget>[
                        SizedBox(
                          height: deviceSize.height / 10,
                        ),
                        Container(
                          width: deviceSize.width * 0.75,
                          height: deviceSize.height * 0.08,
                          child: Material(
                            elevation: 10.0,
                            shadowColor: Color(0xffee8e2e),
                            child: TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(
                                  Icons.person,
                                  color: Color(0xffe65100),
                                ),
                                hintText: 'Email or Phone number',
                                border: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    color: Colors.grey,
                                    width: 0.05,
                                  ),
                                  borderRadius: BorderRadius.only(
                                    topLeft: Radius.circular(5.0),
                                    topRight: Radius.circular(5.0),
                                  ),
                                ),
                              ),
                              keyboardType: TextInputType.emailAddress,
                            ),
                          ),
                        ),
                        Container(
                          width: deviceSize.width * 0.75,
                          height: deviceSize.height * 0.08,
                          child: Material(
                            elevation: 10.0,
                            shadowColor: Color(0xffee8e2e),
                            child: TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(
                                  Icons.lock,
                                  color: Color(0xffe65100),
                                ),
                                hintText: 'Password',
                                border: OutlineInputBorder(
                                  borderSide: BorderSide(
                                    color: Colors.grey,
                                    width: 0.05,
                                  ),
                                  borderRadius: BorderRadius.only(
                                    bottomLeft: Radius.circular(5.0),
                                    bottomRight: Radius.circular(5.0),
                                  ),
                                ),
                              ),
                              obscureText: _obscureText,
                            ),
                          ),
                        ),
                        SizedBox(
                          height: deviceSize.height / 20,
                        ),
                        Text(
                          'Forgot Password?',
                          style: TextStyle(
                            fontSize: 16,
                            color: Colors.grey,
                          ),
                        ),
                        SizedBox(
                          height: deviceSize.height / 15,
                        ),
                        SizedBox(
                          width: deviceSize.width / 2,
                          child: ElevatedButton(
                            style: ElevatedButton.styleFrom(
                              primary: Color(0xffe65100),
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(40.0),
                              ),
                            ),
                            onPressed: () {},
                            child: Text(
                              'Login',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 16,
                                fontFamily: 'Arial',
                              ),
                            ),
                          ),
                        ),
                        SizedBox(
                          height: deviceSize.height / 15,
                        ),
                        Text(
                          'Continue with social media',
                          style: TextStyle(
                            fontSize: 16,
                            color: Colors.grey,
                          ),
                        ),
                        SizedBox(
                          height: deviceSize.height / 30,
                        ),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          children: <Widget>[
                            SizedBox(
                              width: deviceSize.width * 0.4,
                              child: ElevatedButton(
                                style: ElevatedButton.styleFrom(
                                  primary: Color(0xff2196f3),
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(40.0),
                                  ),
                                ),
                                onPressed: () {},
                                child: Text(
                                  'Facebook',
                                  style: TextStyle(
                                    color: Colors.white,
                                    fontSize: 16,
                                    fontFamily: 'Arial',
                                  ),
                                ),
                              ),
                            ),
                            SizedBox(
                              width: deviceSize.width * 0.4,
                              child: ElevatedButton(
                                style: ElevatedButton.styleFrom(
                                  primary: Colors.black,
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(40.0),
                                  ),
                                ),
                                onPressed: () {},
                                child: Text(
                                  'Github',
                                  style: TextStyle(
                                    color: Colors.white,
                                    fontSize: 16,
                                    fontFamily: 'Arial',
                                  ),
                                ),
                              ),
                            ),
                          ],
                        )
                      ],
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
