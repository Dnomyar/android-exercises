package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LibraryActivity : AppCompatActivity(), Step0Fragment.OnNextStep0Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        // TODO replace Step0Fragment in containerFrameLayout

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerFrameLayout, Step0Fragment(), "Step0Fragment")
                .commit()
    }

    override fun onNext() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerFrameLayout, Step1Fragment(), "Step1Fragment")
                .addToBackStack("Step0Fragment")
                .commit()

        // TODO replace Step1Fragment in containerFrameLayout
    }

}
