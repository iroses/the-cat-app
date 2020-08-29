package mx.iroses.thecatapp.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.iroses.thecatapp.R

class BreedsFragment : Fragment() {

    private lateinit var viewModel: BreedsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.breeds_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(BreedsViewModel::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BreedsFragment()
    }
}