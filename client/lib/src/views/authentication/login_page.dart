import 'package:client/src/views/authentication/registration_page.dart';
import 'package:client/src/views/home_page/home_page.dart';
import 'package:flutter/material.dart';
import 'package:client/src/views/components/auth_textfield.dart';
import 'package:client/src/services/auth_services.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;

    return Scaffold(
      backgroundColor: Colors.white,
      body: SingleChildScrollView(
        child: SizedBox(
          width: width,
          height: height,
          child: Column(
            children: [
              SizedBox(
                height: height * 0.15,
              ),
              Container(
                width: width * 0.5,
                height: width * 0.5,
                decoration: const BoxDecoration(
                  image: DecorationImage(
                    image: AssetImage(
                      "assets/authentication_decoration/signin4.png",
                    ),
                    fit: BoxFit.fill,
                  ),
                ),
              ),
              const Text(
                "Welcome!",
                style: TextStyle(
                    fontSize: 35,
                    fontWeight: FontWeight.bold,
                    color: Color.fromARGB(255, 56, 59, 113)),
              ),
              Padding(
                padding: EdgeInsets.symmetric(
                    vertical: height * 0.02, horizontal: 20.0),
                child: const Align(
                  alignment: Alignment.topLeft,
                  child: Text(
                    "Log in to continue",
                    style: TextStyle(
                      fontSize: 25,
                      fontWeight: FontWeight.bold,
                      color: Color(0xFF5D89FA),
                    ),
                  ),
                ),
              ),
              AuthTextField(
                keyboardType: TextInputType.emailAddress,
                controller: emailController,
                hintText: 'e-mail address',
                leadingIcon: const Icon(
                  Icons.email_outlined,
                ),
              ),
              AuthTextField(
                controller: passwordController,
                hintText: 'password',
                obscureText: true,
                leadingIcon: const Icon(
                  Icons.lock_outline,
                ),
              ),
              const SizedBox(
                height: 20.0,
              ),
              ElevatedButton(
                onPressed: () async {
                  final result = await signIn(emailController.text, passwordController.text);
                  print("****************************");
                  print(result.toString());
                  print(result.accessToken);
                   print(result.employee);
                  Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => HomePage(authToken: result)));
                  print("*****************************");
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
                    'Log in',
                    style: TextStyle(fontSize: 18.0),
                  ),
                ),
              ),
              ElevatedButton(
                onPressed: () async {
                  Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => const RegistrationPage()));
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
                    'Register a new account',
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
      content: Text(msg),
    );
  }
}
