import 'package:flutter/material.dart';

void main() {
  runApp(FoodApp());
}

class FoodApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Food App',
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: HomeScreen(),
    );
  }
}

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Food App'),
      ),
      body: Column(
        children: <Widget>[
          // Search Bar
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: TextField(
              decoration: InputDecoration(
                hintText: 'Search for food...',
                prefixIcon: Icon(Icons.search),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(25.0),
                ),
              ),
            ),
          ),
          // Featured Foods
          Container(
            height: 40,
            alignment: Alignment.topLeft,
            margin: const EdgeInsets.all(12.0),
            child: Text(
              'Featured Food',
              style: TextStyle(
                color: Colors.red,
                fontWeight: FontWeight.bold,
                fontSize: 32,
              ),
            ),
          ),
          Container(
            height: 300,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 5,
              itemBuilder: (
                context,
                index,
              ) {
                return FoodCard();
              },
            ),
          ),
          Container(
            height: 40,
            alignment: Alignment.topLeft,
            margin: const EdgeInsets.all(12.0),
            child: Text(
              'Top Restaurents',
              style: TextStyle(
                color: Colors.red,
                fontWeight: FontWeight.bold,
                fontSize: 32,
              ),
            ),
          ),
          // Popular Restaurants
          Container(
            height: 300,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 5,
              itemBuilder: (
                context,
                index,
              ) {
                return RestaurantCard();
              },
            ),
          ),
        ],
      ),
    );
  }
}

class FoodCard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 360,
      margin: EdgeInsets.all(8.0),
      decoration: BoxDecoration(
        color: Colors.orange,
        borderRadius: BorderRadius.circular(10.0),
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Image.asset(
            'assets/food_image.jpg',
            width: 280,
            height: 240,
          ),
          Text(
            'Food Item',
            style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
              fontSize: 24,
            ),
          ),
        ],
      ),
    );
  }
}

class RestaurantCard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 360,
      margin: EdgeInsets.all(8.0),
      decoration: BoxDecoration(
        color: Colors.deepOrange,
        borderRadius: BorderRadius.circular(10.0),
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Image.asset(
            'assets/restaurant_image.jpg',
            width: 280,
            height: 240,
          ),
          Text(
            'Restaurant',
            style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
              fontSize: 24,
            ),
          ),
        ],
      ),
    );
  }
}
