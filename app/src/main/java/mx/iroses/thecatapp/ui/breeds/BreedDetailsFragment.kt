package mx.iroses.thecatapp.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import mx.iroses.thecatapp.data.Breed
import mx.iroses.thecatapp.databinding.BreedDetailsFragmentBinding

class BreedDetailsFragment : Fragment() {

    private lateinit var breed: Breed

    private lateinit var viewDataBinding: BreedDetailsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        breed = arguments?.getParcelable(ARG_BREED) ?: return run { activity?.finish() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = BreedDetailsFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@BreedDetailsFragment.viewLifecycleOwner
            breed = this@BreedDetailsFragment.breed
        }
        return viewDataBinding.root
    }

    companion object {

        const val ARG_BREED = "arg_breed"

        @JvmStatic
        fun newInstance(breed: Breed) = BreedDetailsFragment().apply {
            arguments = bundleOf(
                ARG_BREED to breed
            )
        }
    }
}