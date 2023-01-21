import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:client/src/views/components/auth_textfield.dart';
import 'package:client/src/views/authentication/login_page.dart';
import 'package:client/src/services/auth_services.dart';

class RegistrationPage extends StatefulWidget {
  
  const RegistrationPage({super.key});

  @override
  State<RegistrationPage> createState() => _RegistrationPageState();
}

class _RegistrationPageState extends State<RegistrationPage> {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController passwordConfirmationController =
      TextEditingController();
  final TextEditingController firstNameController = TextEditingController();
  final TextEditingController familyNameController = TextEditingController();
  final TextEditingController addressController = TextEditingController();
  final TextEditingController phoneNumberController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;

    return Scaffold(
      backgroundColor: Colors.white,
      body: SingleChildScrollView(
        child: SizedBox(
          width: width,
          child: Column(
            children: [
              SizedBox(
                height: height * 0.15,
              ),
              Container(
                width: width * 0.8,
                height: width * 0.5,
                decoration: const BoxDecoration(
                  image: DecorationImage(
                    image: AssetImage(
                      "assets/authentication_decoration/signup.png",
                    ),
                    fit: BoxFit.fill,
                  ),
                ),
              ),
              const Text(
                "Joining Us!",
                style: TextStyle(
                    fontSize: 35,
                    fontWeight: FontWeight.bold,
                    color: Color.fromARGB(255, 56, 59, 113)),
              ),
              Padding(
                padding: EdgeInsets.symmetric(
                    vertical: height * 0.02, horizontal: 30.0),
                child: const Text(
                  "Please fill-in the form below",
                  style: TextStyle(
                    fontSize: 25,
                    fontWeight: FontWeight.bold,
                    color: Color(0xFF5D89FA),
                  ),
                ),
              ),
              AuthTextField(
                keyboardType: TextInputType.emailAddress,
                controller: emailController,
                hintText: 'E-mail address',
                leadingIcon: const Icon(
                  Icons.email_outlined,
                ),
              ),
              AuthTextField(
                controller: passwordController,
                hintText: 'Password',
                obscureText: true,
                leadingIcon: const Icon(
                  Icons.lock_outline,
                ),
              ),
              AuthTextField(
                controller: passwordConfirmationController,
                hintText: 'Confirm password',
                obscureText: true,
                leadingIcon: const Icon(
                  Icons.lock_outline,
                ),
              ),
              AuthTextField(
                controller: firstNameController,
                hintText: 'First name',
                obscureText: false,
                leadingIcon: const Icon(
                  Icons.person,
                ),
              ),
              AuthTextField(
                controller: familyNameController,
                hintText: 'Family name',
                obscureText: false,
                leadingIcon: const Icon(
                  Icons.family_restroom,
                ),
              ),
              AuthTextField(
                controller: addressController,
                hintText: 'Address',
                obscureText: false,
                leadingIcon: const Icon(
                  Icons.location_city,
                ),
              ),
              AuthTextField(
                controller: phoneNumberController,
                hintText: 'Phone number',
                obscureText: false,
                leadingIcon: const Icon(
                  Icons.smartphone,
                ),
              ),
              const SizedBox(
                height: 20.0,
              ),
              ElevatedButton(
                onPressed: () async {
                  // Navigator.pushReplacement(context,
                  //     MaterialPageRoute(builder: (context) => HomePage()));
                  List<String> missingFields = [];
                  String emailPattern =
                      r'(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)';
                  RegExp regExp = RegExp(emailPattern);
                  String wrongInputMsg = "";

                  if (emailController.text.isEmpty) {
                    missingFields.add("E-mail address");
                  }
                  if (passwordController.text.isEmpty) {
                    missingFields.add("password");
                  }
                  if (addressController.text.isEmpty) {
                    missingFields.add("address");
                  }
                  if (firstNameController.text.isEmpty) {
                    missingFields.add("first name");
                  }
                  if (familyNameController.text.isEmpty) {
                    missingFields.add("family name");
                  }
                  if (phoneNumberController.text.isEmpty) {
                    missingFields.add("phone number");
                  }
                  if (missingFields.isNotEmpty) {
                    String missingNames = missingFields[0];
                    for (int i = 1; i < missingFields.length; i++) {
                      missingNames += ", ${missingFields[i]}";
                    }
                    wrongInputMsg =
                        'Please fill all fields. You are missing:\n$missingNames.';
                  } else if (passwordConfirmationController.text !=
                      passwordController.text) {
                    wrongInputMsg = 'Passwords do not match, try again!';
                  } else if (!regExp.hasMatch(emailController.text)) {
                    wrongInputMsg = 'Wrong Email format, silly!';
                  } else if (passwordController.text.length < 8) {
                    wrongInputMsg =
                        'Password needs to be at least 8 characters long!';
                  }
                  if (wrongInputMsg.isNotEmpty) {
                    ScaffoldMessenger.of(context).showSnackBar(
                      _buildSnackBar(wrongInputMsg),
                    );
                  } else {
                    final result = await signup(
                        emailController.text,
                        passwordController.text,
                        firstNameController.text,
                        familyNameController.text,
                        phoneNumberController.text,
                        "ADMIN",
                        addressController.text);
                    if (result.statusCode != 200) {
                      if (wrongInputMsg.isNotEmpty) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          _buildSnackBar(
                              "An error has accured ${result.statusCode}"),
                        );
                      } else {
                        Navigator.pushReplacement(
                            context,
                            MaterialPageRoute(
                                builder: (context) => LoginPage()));
                      }
                    }
                  }
                },
                style: ButtonStyle(
                  backgroundColor:
                      MaterialStateProperty.all<Color>(const Color(0xFF5D89FA)),
                  shape: MaterialStateProperty.all<OutlinedBorder>(
                      RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20.0))),
                ),
                child: const Padding(
                  padding:
                      EdgeInsets.symmetric(horizontal: 20.0, vertical: 8.0),
                  child: Text(
                    'Sign up',
                    style: TextStyle(fontSize: 18.0),
                  ),
                ),
              ),
              ElevatedButton(
                onPressed: () async {
                  Navigator.pushReplacement(
                      context,
                      MaterialPageRoute(
                          builder: (context) => const LoginPage()));
                },
                style: ButtonStyle(
                  backgroundColor:
                      MaterialStateProperty.all<Color>(const Color(0xFF5D89FA)),
                  shape: MaterialStateProperty.all<OutlinedBorder>(
                      RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20.0))),
                ),
                child: const Padding(
                  padding:
                      EdgeInsets.symmetric(horizontal: 20.0, vertical: 8.0),
                  child: Text(
                    'Go back to sign in screen',
                    style: TextStyle(fontSize: 18.0),
                  ),
                ),
              ),
              const SizedBox(
                height: 20.0,
              ),
            ],
          ),
        ),
      ),
    );
  }

  SnackBar _buildSnackBar(String msg) {
    return SnackBar(
      content: Text(
        msg,
        style: TextStyle(fontSize: 18),
      ),
      backgroundColor: Color.fromARGB(255, 255, 104, 93),
    );
  }
}
