package org.oppia.app.player.state.hintsandsolution

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.DialogFragment
import org.oppia.app.R

/**
 * DialogFragment that indicates to the user they are on cellular when trying to play an audio voiceover.
 */
class RevealSolutionDialogFragment : DialogFragment() {
  companion object {
    /**
     * This function is responsible for displaying content in DialogFragment.
     *
     * @return [RevealSolutionDialogFragment]: DialogFragment
     */
    fun newInstance(): RevealSolutionDialogFragment {
      return RevealSolutionDialogFragment()
    }
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val view = View.inflate(context, R.layout.reveal_solution_dialog, /* root= */ null)

    val revealSolutionInterface: RevealSolutionInterface = parentFragment as HintsAndSolutionFragment

    return AlertDialog.Builder(ContextThemeWrapper(activity as Context, R.style.OppiaDialogFragmentTheme))
      .setTitle(R.string.reveal_solution)
      .setView(view)
      .setMessage(getString(R.string.this_will_reveal_the_solution))
      .setPositiveButton(getString(R.string.reveal)) { _, _ ->
        revealSolutionInterface.revealSolution(true)
        dismiss()
      }
      .setNegativeButton(R.string.cellular_data_alert_dialog_cancel_button) { _, _ ->
        revealSolutionInterface.revealSolution(false)
        dismiss()
      }
      .create()
  }
}
