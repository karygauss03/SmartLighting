import 'package:flutter/material.dart';

class ListingPage extends StatefulWidget {
  final List<dynamic> elements;
  final String type;
  const ListingPage({super.key, required this.elements, required this.type});

  @override
  State<ListingPage> createState() => _ListingPageState();
}

class _ListingPageState extends State<ListingPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color.fromARGB(255, 7, 50, 118),
      ),
      body: ListView.builder(
        itemCount: widget.elements.length,
        itemBuilder: (context, index) {
          return Card(
            elevation: 5,
            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10.0)),
            child: ListTile(
              leading: widget.type == "Employee"? Icon(Icons.person): widget.type == "Assignment"? Icon(Icons.task): Icon(Icons.lightbulb),
              title: Text("${widget.type == "Employee"? widget.elements[index].firstName + ' ' + widget.elements[index].familyName: 
                          widget.type == "Assignment"? "assignment id: " + widget.elements[index].id: "module id: " + widget.elements[index].id}"
              ),
              subtitle: Text("${widget.type == "Employee"? widget.elements[index].email: 
                          widget.type == "Assignment"? "employee : " + widget.elements[index].employeeId + "assinged to module" +  widget.elements[index].lightModuleId: "module is: " + (widget.elements[index].isOn?"on": "off")}"),
            ),
          );
        },
      ),
    );
  }
}


