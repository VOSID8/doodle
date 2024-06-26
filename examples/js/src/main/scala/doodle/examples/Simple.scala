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

package doodle.examples

import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.interact.syntax.all.*
import doodle.svg.*
import doodle.syntax.all.*

import scala.scalajs.js.annotation.*

@JSExportTopLevel("Simple")
object Simple {
  @JSExport
  def ball(id: String) =
    -100.0
      .upTo(100.0)
      .map(x =>
        Picture
          .circle(15)
          .fillColor(Color.chartreuse)
          .strokeWidth(3.0)
          .at(x, 0.0)
      )
      .forSteps(100)
      .repeatForever
      .animate(Frame(id).withSize(230, 30))
}
