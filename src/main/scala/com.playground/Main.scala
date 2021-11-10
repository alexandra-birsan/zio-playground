package com.playground

import zio.{ExitCode, ZEnv, ZIO}
import zio.console._

import zio.random._

object Main extends zio.App {

  val effect: ZIO[Console, Nothing, Unit] = putStrLn("Hello, World!").orDie
  val mainApp: ZIO[Any, Nothing, Unit] = effect.provideLayer(Console.live)

  val effect2: ZIO[Console with Random, Nothing, Unit] = for {
    r <- nextInt
    _ <- putStrLn(s"random number: $r").orDie
  } yield ()
  val mainApp2: ZIO[Any, Nothing, Unit] = effect2.provideLayer(Console.live ++ Random.live)

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    mainApp2.exitCode
}