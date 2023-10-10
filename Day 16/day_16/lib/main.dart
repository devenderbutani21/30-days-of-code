import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Meetup App',
      theme: ThemeData(
        primaryColor: Colors.black,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    Size deviceSize = MediaQuery.of(context).size;
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        leading: IconButton(
          icon: Icon(
            Icons.arrow_back,
            color: Colors.blue,
          ),
          onPressed: () {},
        ),
        title: Text(
          'Meetup',
          style: TextStyle(color: Colors.blue),
        ),
        actions: <Widget>[
          Container(
            width: 50,
            child: MaterialButton(
              child: Icon(
                Icons.search,
                color: Colors.blue,
                size: 30,
              ),
              onPressed: () {},
            ),
          ),
        ],
      ),
      body: SingleChildScrollView(
        child: Stack(children: <Widget>[
          Container(
            height: deviceSize.height,
            width: double.infinity,
            color: Colors.blue.shade300,
            child: Column(
              children: <Widget>[
                SizedBox(
                  height: 720,
                ),
                Text(
                  'Today 9:00 PM',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 19,
                  ),
                ),
                Text(
                  'Easy and Gentle Yoga',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                RawMaterialButton(
                  onPressed: () {},
                  elevation: 2.0,
                  fillColor: Colors.blue.shade200,
                  child: Text(
                    'You are going!',
                    style: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                  padding: EdgeInsets.all(10.0),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(18.0),
                  ),
                ),
              ],
            ),
          ),
          ClipRRect(
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(100.0),
            ),
            child: Container(
              height: deviceSize.height * 3 / 4,
              width: double.infinity,
              color: Colors.blue.shade200,
              child: Column(
                children: <Widget>[
                  SizedBox(
                    height: 520,
                  ),
                  Text(
                    'Today 8:00 PM',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 19,
                    ),
                  ),
                  Text(
                    'Practice French, English, and Chinese',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      RawMaterialButton(
                        onPressed: () {},
                        elevation: 2.0,
                        child: Icon(
                          Icons.check_circle_outline,
                          size: 40.0,
                          color: Colors.blueAccent,
                        ),
                        shape: CircleBorder(),
                      ),
                      RawMaterialButton(
                        onPressed: () {},
                        elevation: 2.0,
                        child: Icon(
                          Icons.cancel,
                          size: 40.0,
                          color: Colors.blueAccent,
                        ),
                        shape: CircleBorder(),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
          ClipRRect(
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(100.0),
            ),
            child: Container(
              height: deviceSize.height * 1 / 2,
              width: double.infinity,
              color: Colors.blue.shade100,
              child: Column(
                children: <Widget>[
                  SizedBox(
                    height: 280,
                  ),
                  Text(
                    'Today 6:00 PM',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 19,
                    ),
                  ),
                  Text(
                    'Yoga and Meditation for Beginners',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      Stack(
                        children: <Widget>[
                          CircleAvatar(
                            radius: 18,

                          ),
                          Container(
                            margin: EdgeInsets.only(
                              left: 20,
                            ),
                            child: CircleAvatar(
                              radius: 18,
                            ),
                          ),
                          Container(
                            margin: EdgeInsets.only(
                              left: 40,
                            ),
                            child: CircleAvatar(
                              radius: 18,
                            ),
                          ),
                          Container(
                            margin: EdgeInsets.only(
                              left: 60,
                            ),
                            child: CircleAvatar(
                              radius: 18,
                            ),
                          ),
                          Container(
                            margin: EdgeInsets.only(
                              left: 80,
                            ),
                            child: CircleAvatar(
                              radius: 18,
                            ),
                          ),
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Text(
                        'Marie and 4 others',
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 20,
                          fontWeight: FontWeight.bold,
                        ),
                      )
                    ],
                  ),
                ],
              ),
            ),
          ),
          ClipRRect(
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(100.0),
            ),
            child: Container(
              height: deviceSize.height * 1 / 4,
              width: double.infinity,
              color: Colors.white70,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  RawMaterialButton(
                    onPressed: () {},
                    elevation: 2.0,
                    fillColor: Colors.white,
                    child: Icon(
                      Icons.music_note,
                      size: 35.0,
                      color: Colors.blue.shade200,
                    ),
                    padding: EdgeInsets.all(15.0),
                    shape: CircleBorder(),
                  ),
                  RawMaterialButton(
                    onPressed: () {},
                    elevation: 2.0,
                    fillColor: Colors.white,
                    child: Icon(
                      Icons.poll,
                      size: 35.0,
                      color: Colors.blue.shade200,
                    ),
                    padding: EdgeInsets.all(15.0),
                    shape: CircleBorder(),
                  ),
                  RawMaterialButton(
                    onPressed: () {},
                    elevation: 2.0,
                    fillColor: Colors.white,
                    child: Icon(
                      Icons.favorite_border,
                      size: 35.0,
                      color: Colors.blue.shade200,
                    ),
                    padding: EdgeInsets.all(15.0),
                    shape: CircleBorder(),
                  ),
                ],
              ),
            ),
          ),
        ]),
      ),
    );
  }
}
