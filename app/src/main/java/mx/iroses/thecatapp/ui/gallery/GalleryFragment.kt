package mx.iroses.thecatapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import mx.iroses.thecatapp.databinding.GalleryFragmentBinding

class GalleryFragment : Fragment() {

    private lateinit var viewDataBinding: GalleryFragmentBinding

    private val viewModel: GalleryViewModel by lazy {
        ViewModelProvider(
            this, GalleryViewModelFactory.getInstance()
        ).get(GalleryViewModel::class.java)
    }

    private val galleryAdapter: GalleryAdapter by lazy { GalleryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = GalleryFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@GalleryFragment.viewLifecycleOwner
            viewModel = this@GalleryFragment.viewModel
            galleryRecyclerView.adapter = this@GalleryFragment.galleryAdapter
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.viewModel?.apply {
            items.observe(viewLifecycleOwner) { images ->
                galleryAdapter.clear()
                galleryAdapter.addAll(images)
            }
        }

        viewDataBinding.viewModel?.loadImages()
    }

    companion object {
        @JvmStatic
        fun newInstance() = GalleryFragment()
    }
}