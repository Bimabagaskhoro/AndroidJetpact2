package com.bimabagaskhoro.submissionjetpactpro2.utils

import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.movie.MovieRemote
import com.bimabagaskhoro.submissionjetpactpro2.model.data.remote.response.tvshow.TvShowRemote

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {

        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(
                632357,
                "The Unholy",
                "2021-03-31",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "en"
            )
        )

        movie.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "en"
            )
        )

        movie.add(
            MovieEntity(
                615457,
                "Nobody",
                "2021-03-24",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "en"
            )
        )

        movie.add(
            MovieEntity(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "en"
            )
        )

        movie.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "en"
            )
        )
        return movie
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                63174,
                "Lucifer",
                "2016-01-25",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "en"
            )
        )

        tvShow.add(
            TvShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "en"
            )
        )

        tvShow.add(
            TvShowEntity(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "en"
            )
        )

        tvShow.add(
            TvShowEntity(
                79008,
                "Luis Miguel: The Series",
                "2018-04-22",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "en"
            )
        )

        tvShow.add(
            TvShowEntity(
                65820,
                "Van Helsing",
                "2016-09-23",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                "en"
            )
        )

        return tvShow
    }

    fun getRemoteMovies(): ArrayList<MovieRemote> {

        val remoteMovie = ArrayList<MovieRemote>()
        remoteMovie.add(
            MovieRemote(
                632357,
                "The Unholy",
                "2021-03-31",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "en"
            )
        )

        remoteMovie.add(
            MovieRemote(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "en"
            )
        )

        remoteMovie.add(
            MovieRemote(
                615457,
                "Nobody",
                "2021-03-24",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "en"
            )
        )

        remoteMovie.add(
            MovieRemote(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "en"
            )
        )

        remoteMovie.add(
            MovieRemote(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "en"
            )
        )
        return remoteMovie
    }


    fun getRemoteTVShows(): ArrayList<TvShowRemote> {

        val tvShowRemote = ArrayList<TvShowRemote>()

        tvShowRemote.add(
            TvShowRemote(
                63174,
                "Lucifer",
                "2016-01-25",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "en"
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                88396,
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "en"
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "en"
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                79008,
                "Luis Miguel: The Series",
                "2018-04-22",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "en"
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                65820,
                "Van Helsing",
                "2016-09-23",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                "en"
            )
        )

        return tvShowRemote
    }
}