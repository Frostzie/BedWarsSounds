package io.github.frostzie.bedwars_sounds.utils

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.concurrent.TimeUnit

class RepoManager(private val targetDirectory: File) {

    var githubRawUrl: String? = "https://raw.githubusercontent.com/Frostzie/BedWarsSounds/refs/heads/master/constants/KillMessages.json"

    /**
     * Attempts to download the configured GitHub raw URL into the target directory as the given filename
     * (defaults to "KillMessages.json"). Returns true if a download was attempted and succeeded.
     * If githubRawUrl is null/blank this is a no-op and returns false.
     */
    fun tryDownloadJsonIfConfigured(filename: String = "KillMessages.json"): Boolean {
        val urlStr = githubRawUrl
        if (urlStr.isNullOrBlank()) return false

        try {
            downloadToTarget(urlStr, filename)
            println("RepoManager: downloaded remote config to ${targetDirectory.resolve(filename)}")
            return true
        } catch (e: Exception) {
            println("RepoManager: failed to download remote config: ${e.message}")
            return false
        }
    }

    @Throws(Exception::class)
    private fun downloadToTarget(urlStr: String, filename: String) {
        val url = URL(urlStr)
        val conn = (url.openConnection() as HttpURLConnection).apply {
            connectTimeout = TimeUnit.SECONDS.toMillis(10).toInt()
            readTimeout = TimeUnit.SECONDS.toMillis(15).toInt()
            requestMethod = "GET"
            instanceFollowRedirects = true
        }

        try {
            val responseCode = conn.responseCode
            if (responseCode !in 200..299) {
                throw Exception("HTTP $responseCode")
            }

            targetDirectory.mkdirs()
            val targetFile = targetDirectory.resolve(filename)
            val tmpFile = targetDirectory.resolve("$filename.download")

            BufferedInputStream(conn.inputStream).use { input ->
                BufferedOutputStream(FileOutputStream(tmpFile)).use { output ->
                    val buffer = ByteArray(8 * 1024)
                    var bytesRead: Int
                    while (input.read(buffer).also { bytesRead = it } != -1) {
                        output.write(buffer, 0, bytesRead)
                    }
                }
            }

            // Move atomically (replace existing)
            Files.move(
                tmpFile.toPath(),
                targetFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.ATOMIC_MOVE
            )
        } finally {
            conn.disconnect()
        }
    }
}
