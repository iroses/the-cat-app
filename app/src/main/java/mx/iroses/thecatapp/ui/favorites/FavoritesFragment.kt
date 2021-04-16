package mx.iroses.thecatapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import mx.iroses.thecatapp.databinding.FavoritesFragmentBinding

class FavoritesFragment : Fragment() {

    private lateinit var viewDataBinding: FavoritesFragmentBinding

    private val viewModel: FavoritesViewModel by lazy {
        ViewModelProvider(
            this, FavoritesViewModelFactory.getInstance()
        ).get(FavoritesViewModel::class.java)
    }

    private val favoritesAdapter: FavoritesAdapter by lazy { FavoritesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FavoritesFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FavoritesFragment.viewLifecycleOwner
            viewModel = this@FavoritesFragment.viewModel
            favoritesRecyclerView.adapter = this@FavoritesFragment.favoritesAdapter
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.viewModel?.apply {
            items.observe(viewLifecycleOwner) { favorites ->
                favorites.clear()
                favorites.addAll(favorites)
            }
        }

        viewDataBinding.viewModel?.loadFavorites()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavoritesFragment()
    }
}