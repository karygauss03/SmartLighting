import 'package:flutter/material.dart';

class AuthTextField extends StatelessWidget {
  final String hintText;
  final Icon leadingIcon;
  final Icon? trailingIcon;
  final bool obscureText;
  final TextEditingController controller;
  final TextInputType keyboardType;
  const AuthTextField(
      {Key? key,
      required this.hintText,
      required this.leadingIcon,
      this.trailingIcon,
      required this.controller,
      this.obscureText = false,
      this.keyboardType = TextInputType.text})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 20.0, vertical: 5.0),
      margin: const EdgeInsets.symmetric(horizontal: 20.0, vertical: 10.0),
      decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(50.0),
          boxShadow: [
            BoxShadow(
                color: Colors.grey.shade300,
                offset: const Offset(2.0, 4.0),
                blurRadius: 4.0)
          ]),
      child: TextField(
        keyboardType: keyboardType,
        obscureText: obscureText,
        controller: controller,
        autocorrect: false,
        decoration: InputDecoration(
          border: InputBorder.none,
          hintText: hintText,
          icon: leadingIcon,
        ),
      ),
    );
  }
}
