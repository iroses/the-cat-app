package mx.iroses.thecatapp.ui.breeds

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.iroses.thecatapp.databinding.BreedsFragmentBinding

class BreedsFragment : Fragment() {

    private lateinit var viewDataBinding: BreedsFragmentBinding

    private val viewModel: BreedsViewModel by lazy {
        ViewModelProvider(this, BreedsViewModelFactory()).get(BreedsViewModel::class.java)
    }

    private val breedsAdapter: BreedsAdapter by lazy {
        BreedsAdapter {
            startActivity(Intent(context, BreedDetailsActivity::class.java).apply {
                putExtra(BreedDetailsFragment.ARG_BREED, it)
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding =
            BreedsFragmentBinding.inflate(inflater, container, false).apply {
                viewModel = this@BreedsFragment.viewModel
                lifecycleOwner = this@BreedsFragment.viewLifecycleOwner
            }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.breedsRecyclerView.adapter = breedsAdapter

        viewDataBinding.viewModel?.let { viewModel ->
            viewModel.items.observe(viewLifecycleOwner, { breeds ->
                breedsAdapter.addAll(breeds)
            })
        }

        viewModel.loadBreeds()
    }

    companion object {
        @JvmStatic
        fun newInstance() = BreedsFragment()
    }
}