package org.carlosjgr7.project.data.remote.response

import kotlinx.serialization.Serializable
import org.carlosjgr7.project.domain.model.EpisodeModel
import org.carlosjgr7.project.domain.model.SeasonEpisode


@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val episode: String,
    val characters: List<String>,
) {
    fun toDomain(): EpisodeModel {
        val season = getSeason(episode)
        return EpisodeModel(
            id = id,
            name = name,
            episode = episode,
            characters = characters.map { it.substringAfterLast("/") },
            videoURL = getVideoURL(season),
            season = season
        )
    }

    private fun getVideoURL(season: SeasonEpisode): String {
        return when (season) {
            SeasonEpisode.SEASON_1 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.SEASON_2 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.SEASON_3 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.SEASON_4 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.SEASON_5 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.SEASON_6 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.SEASON_7 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SeasonEpisode.UNKNOWN -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
        }

    }

    private fun getSeason(episode: String): SeasonEpisode {
        return when {
            episode.startsWith("S01") -> SeasonEpisode.SEASON_1
            episode.startsWith("S02") -> SeasonEpisode.SEASON_2
            episode.startsWith("S03") -> SeasonEpisode.SEASON_3
            episode.startsWith("S04") -> SeasonEpisode.SEASON_4
            episode.startsWith("S05") -> SeasonEpisode.SEASON_5
            episode.startsWith("S06") -> SeasonEpisode.SEASON_6
            episode.startsWith("S07") -> SeasonEpisode.SEASON_7
            else -> SeasonEpisode.UNKNOWN
        }
    }
}
