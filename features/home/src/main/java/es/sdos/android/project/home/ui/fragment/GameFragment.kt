package es.sdos.android.project.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import es.sdos.android.project.common.di.ViewModelFactory
import es.sdos.android.project.common.ui.BaseFragment
import es.sdos.android.project.common.ui.BaseViewModel
import es.sdos.android.project.data.model.game.RoundBo
import es.sdos.android.project.data.repository.util.AsyncResult
import es.sdos.android.project.feature.home.databinding.FragmentGameBinding
import es.sdos.android.project.home.ui.adapter.RoundAdapter
import es.sdos.android.project.home.ui.viewmodel.GameViewModel
import javax.inject.Inject
import es.sdos.android.project.data.model.game.addShot

class GameFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<GameViewModel>
    private val viewModel: GameViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentGameBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO viewModel.requestGame(args.id)

        var gameIDArg = arguments!!.getLong("gameId")

        viewModel.requestGame(gameIDArg)
        viewModel.getGameLiveData().observe(viewLifecycleOwner, Observer { result ->
            binding.game = result.data?.takeIf { result.status == AsyncResult.Status.SUCCESS }
        })

        var adapter = RoundAdapter()

        binding.gameListRounds.adapter = adapter

        var shoots: List<RoundBo> = emptyList()

        binding.gameBtnShotSubmit.setOnClickListener {
            if(binding.gameInputShotScore.text.isNotEmpty()) {
                Toast.makeText(requireActivity(), "Se va añadir la tirada con valor ${binding.gameInputShotScore.text}", Toast.LENGTH_SHORT).show()

                shoots = shoots.addShot(gameIDArg, binding.gameInputShotScore.text.toString().toInt())
                adapter.updateData(shoots)
            }
        }
    }

    override fun getViewModel() = viewModel as BaseViewModel

}