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

package doodle
package syntax

import doodle.algebra.Image
import doodle.effect.{DefaultRenderer, Renderer}

trait RendererSyntax {
  implicit class RendererImageOps[Algebra, F[_], A](
      image: Image[Algebra, F, A]) {
    def draw[Frame, Canvas](frame: Frame)(
        implicit renderer: Renderer[Algebra, F, Frame, Canvas]): A =
      (for {
        canvas <- renderer.frame(frame)
        a <- renderer.render(canvas)(algebra => image(algebra))
      } yield a).unsafeRunSync()

    def draw[Frame, Canvas]()(
        implicit renderer: DefaultRenderer[Algebra, F, Frame, Canvas]): A =
      (for {
        canvas <- renderer.frame(renderer.default)
        a <- renderer.render(canvas)(algebra => image(algebra))
      } yield a).unsafeRunSync()
  }
}