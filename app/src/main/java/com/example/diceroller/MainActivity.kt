package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/** Allows user to roll the dice and
 * view result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts.
        rollDice()
    }

    /** Roll the dice and update the screen
     * with a result.
     */
    private fun rollDice() {
        // Create new dice object with 6 sides and roll it.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find image view in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource to use based on the dice roll.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update image view with the correct drawable resource.
        diceImage.setImageResource(drawableResource)

        // Update the content description.
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}