import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:client/src/views/category_listing_page/category_listing_page.dart';
import 'package:http/http.dart' as http;

class HomePageCard extends StatefulWidget {
  final List elements;
  final Color cardColor;
  final Color shadowColor;
  final String iconPath;
  final String category;
  final int totalCount;
  const HomePageCard(
      {super.key,
      required this.elements,
      required this.cardColor,
      required this.shadowColor,
      required this.iconPath,
      required this.category,
      required this.totalCount});

  @override
  State<HomePageCard> createState() => _HomePageCardState();
}

class _HomePageCardState extends State<HomePageCard> {
  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;

    return GestureDetector(
      onTap: () {
        print("***************************");
        print("the are ${widget.elements.length} elements");
        print("***************************");
        Navigator.push(context, MaterialPageRoute(builder: (context) => ListingPage(elements: widget.elements, type: widget.category,)));
      },
      child: Container(
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(15.0),
          color: widget.cardColor,
          boxShadow: [
            BoxShadow(
              color: widget.shadowColor,
              spreadRadius: 2,
              blurRadius: 5,
              offset: const Offset(3, 3),
            ),
          ],
        ),
        child: Padding(
          padding: EdgeInsets.symmetric(horizontal: 0.06 * width),
          child: Row(
            children: [
              CircleAvatar(
                radius: 0.12 * width,
                backgroundColor: Colors.white,
                foregroundImage: AssetImage(widget.iconPath),
              ),
              SizedBox(width: 0.05 * width),
              Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "${widget.category}s",
                    style: const TextStyle(
                      fontSize: 30,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                    ),
                  ),
                  const SizedBox(height: 5.0),
                  Text(
                    "Registered: ${widget.totalCount}",
                    style: const TextStyle(
                      fontSize: 18,
                      color: Colors.white,
                    ),
                  ),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
