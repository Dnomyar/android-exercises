package fr.android.androidexercises

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Step0Fragment : Fragment() {

    private var listener: OnNextStep0Listener? = null
    private var tv: TextView? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listener = context as OnNextStep0Listener?
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_step0, container, false)
        // TODO findViewById textView (TextView)
        // TODO findViewById nextButton (Button)

        tv = view.findViewById(R.id.textView)
        //val button = view.findViewById<Button>(R.id.nextButton)

        tv?.text = step0

        tv?.setOnClickListener(View.OnClickListener {
            listener?.onNext()
        })
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv?.text = step0
    }

    interface OnNextStep0Listener {
        fun onNext()
    }

    companion object {

        private val step0 = "This is step 0"
    }
}
