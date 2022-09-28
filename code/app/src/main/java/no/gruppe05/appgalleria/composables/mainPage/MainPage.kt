package no.gruppe05.appgalleria.composables.mainPage

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import no.gruppe05.appgalleria.composables.topBar.MainPageTopbar



@Composable
fun MainPage(mainPageViewModel: MainPageViewModel = viewModel()) {

    Scaffold(
        topBar = { MainPageTopbar() }
    ) {
        
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMain() {
    MainPage()
}