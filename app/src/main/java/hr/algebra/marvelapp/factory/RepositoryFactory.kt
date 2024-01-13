package hr.algebra.marvelapp.factory

import android.content.Context
import hr.algebra.marvelapp.dao.MarvelSqlHelper

fun getRepository(context: Context?) = MarvelSqlHelper(context)