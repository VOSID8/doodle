/*
 * Copyright 2015 Creative Scala
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package docs

// The "Image" DSL is the easiest way to create images
import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*

object Chessboard {
  val blackSquare = Image.rectangle(30, 30).fillColor(Color.black)
  val redSquare = Image.rectangle(30, 30).fillColor(Color.red)

// A chessboard, broken into steps showing the recursive construction
  val twoByTwo =
    (redSquare
      .beside(blackSquare))
      .above(blackSquare.beside(redSquare))

  val fourByFour =
    (twoByTwo
      .beside(twoByTwo))
      .above(twoByTwo.beside(twoByTwo))

  val chessboard =
    (fourByFour
      .beside(fourByFour))
      .above(fourByFour.beside(fourByFour))

  chessboard.save("chessboard.png")
}
