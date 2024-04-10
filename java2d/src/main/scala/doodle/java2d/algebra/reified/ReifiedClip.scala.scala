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
package java2d
package algebra
package reified

import cats.Eval
import cats.data.State
import cats.data.WriterT
import doodle.algebra.generic._
import doodle.core.BoundingBox
import doodle.core.Transform

import java.io.File
import javax.imageio.ImageIO

trait ReifiedClip extends doodle.algebra.Clip {
  self: Algebra { type Drawing[A] <: doodle.java2d.Drawing[A] } =>

  def clip[A](image: Drawing[A],clip_path: ClosedPath): Drawing[Unit] = ???
}

