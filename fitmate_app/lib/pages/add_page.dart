import 'package:flutter/material.dart';

class AddPage extends StatelessWidget {
  const AddPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('오늘의 목표'),
      ),
      body: Column(children: [
        const Padding(
          padding: EdgeInsets.all(8.0),
          child: Text('오늘 날짜'),
        ),
        Row(
          children: [Text('칼로리 목표'), TextField(), Text('Kcal')],
        )
      ]),
    );
  }
}
