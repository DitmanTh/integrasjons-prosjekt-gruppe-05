package no.gruppe05.appgalleria.composables.mainPage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import no.gruppe05.appgalleria.composables.bottomBar.MainPageBottomBar
import no.gruppe05.appgalleria.composables.topBar.MainPageTopbar
import no.gruppe05.appgalleria.data.ApplicationInformation


/**
 * The main page of the application, including the topBar, bottomBar, and the center part of the page
 *
 *  The viewModel is the part of the code that will contain the variables of the code. This is
 *  because we do not want to store variables in Composable functions if we can avoid it
 */
@Composable
fun MainPage(mainPageViewModel: MainPageViewModel = viewModel()) {

    Scaffold(
        topBar = { MainPageTopbar()},
        bottomBar = { MainPageBottomBar()}
    ) {
        GalleryOfApps(mainPageViewModel.currentlyShownApps)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GalleryOfApps(appList: List<ApplicationInformation>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(4),
        contentPadding = PaddingValues(all = 4.dp),
        content = {
            items(appList) { app ->
                Application(app = app)
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMain() {
    MainPage()
}