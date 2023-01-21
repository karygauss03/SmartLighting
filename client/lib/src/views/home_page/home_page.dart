import 'dart:convert';

import 'package:client/models/assignment.dart';
import 'package:client/models/employee.dart';
import 'package:client/models/light_module.dart';
import 'package:client/src/views/authentication/login_page.dart';
import 'package:flutter/material.dart';
import 'package:client/src/views/components/home_page_card.dart';
import 'package:client/src/services/auth_services.dart';
import 'package:client/src/services/rest_services/api_requests.dart';

class HomePage extends StatefulWidget {
  final AuthToken authToken;
  const HomePage({super.key, required this.authToken});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  List<Assignment> assignmentList = [];
  List<Employee> employeeList = [];
  List<LightModule> moduleList = [];
  @override
  void initState() {
    super.initState();
    getLists();
  }

  void getLists() async {
    final employees = await fetchResource("/employees", widget.authToken.accessToken);
    
    final assignments = await fetchResource("/assignments", widget.authToken.accessToken);
    final lightModules = await fetchResource("/lighting-modules", widget.authToken.accessToken);
    print("***************************************");
    print(employees.statusCode);
    print(assignments.statusCode);
    print(lightModules.statusCode);
    print("***************************************");
    Iterable em = json.decode(employees.body);
    employeeList = List<Employee>.from(em.map((model)=> Employee(address: "", email: "", familyName: "", firstName: "", phoneNumber: "").fromJson(model)));

    Iterable as = json.decode(assignments.body);
    assignmentList = List<Assignment>.from(as.map((model)=> Assignment(completionDate: "", employeeId: "", id: "",isRepaired: true, lightModuleId: "").fromJson(model)));

    Iterable lm = json.decode(lightModules.body);
    moduleList = List<LightModule>.from(lm.map((model)=> LightModule(address: "",archived: true,createdOn: "",id: "",isApproved: true,isBroken: true,isOn: true,lat: 50,lon: 10.0).fromJson(model)));
    print("***************************************");
    print(employeeList);
    print(assignmentList);
    print(moduleList);
    print("***************************************");
  }

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 7, 50, 118),
        title: Text("Welcome!"),
        actions: [
          IconButton(
            onPressed: () {
              Navigator.pushReplacement(context, MaterialPageRoute(builder: (context)=>LoginPage()));
            },
            icon: const Icon(Icons.logout),
          ),
        ],
      ),
      body: Padding(
        padding: EdgeInsets.symmetric(
            horizontal: 0.03 * width, vertical: 0.02 * height),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Expanded(
              flex: 1,
              child: HomePageCard(
                elements: employeeList,
                cardColor: Color.fromARGB(255, 243, 178, 101),
                shadowColor: Color.fromARGB(255, 240, 191, 144),
                category: "Employee",
                iconPath: "assets/home_page_icons/worker.jpg",
                totalCount: employeeList.length,
              ),
            ),
            SizedBox(height: 15.0),
            Expanded(
              flex: 1,
              child: HomePageCard(
                elements: assignmentList,
                cardColor: Color.fromARGB(255, 129, 186, 242),
                shadowColor: Color.fromARGB(255, 146, 190, 255),
                category: "Assignment",
                iconPath: "assets/home_page_icons/assignment.jpg",
                totalCount: assignmentList.length,
              ),
            ),
            SizedBox(height: 15.0),
            Expanded(
              flex: 1,
              child: HomePageCard(
                elements: moduleList,
                cardColor: Color.fromARGB(255, 204, 144, 235),
                shadowColor: Color.fromARGB(255, 177, 159, 255),
                category: "Light Module",
                iconPath: "assets/home_page_icons/light_bulb.png",
                totalCount: moduleList.length,
              ),
            ),
          ],
        ),
      ),
      // drawer: const Drawer(),
    );
  }
}
