package com.kodega.roll_dice

import android.database.DatabaseUtils
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.kodega.roll_dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity:AppCompatActivity() {
    lateinit var rollBtn:Button;
    lateinit var diceView:ImageView;


    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //setContentView(R.layout.activity_main)

        //rollBtn=findViewById<Button>(R.id.role_dice);
        //diceView=findViewById<TextView>(R.id.dice_number);

        rollBtn=binding.roleDice;
        diceView=binding.diceImage;

        rollBtn.setOnClickListener{
            rollDice();
        }
    }

    private fun rollDice():Unit{
         var dice= Random.nextInt(6)+1;
         var drawableResource=when(dice){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else->R.drawable.dice_6
            }

        diceView.setImageResource(drawableResource);
    }
}