package com.example.navigationbasedonfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationbasedonfragments.databinding.ActivityMainBinding
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val faker = Faker.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            val fragment = CounterFragment.newInstance(
                counterValue = 1,
                quote = createQuote()
            )
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }

    }

    fun createQuote(): String {
        return faker.harryPotter().quote()
    }

    fun getScreensCount(): Int {
        return supportFragmentManager.backStackEntryCount + 1
    }
}