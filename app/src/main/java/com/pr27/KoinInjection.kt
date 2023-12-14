package com.pr27


import com.pr27.data.BookDatabase
import com.pr27.data.BookRepository
import com.pr27.main_activity.MainActivityBookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@JvmField
val koinModule = module {
    single<BookRepository> { BookDatabase(get()) }

    viewModel { MainActivityBookViewModel(get()) }
}