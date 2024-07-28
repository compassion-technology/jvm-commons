/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.client;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Identifiable implements Serializable {
	private Integer id;
	private String name;
	
	public static Identifiable of(int id) { return of(id, null); }
}
