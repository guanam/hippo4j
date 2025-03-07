/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.hippo4j.auth.filter;

import cn.hippo4j.common.toolkit.ReflectUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

class JWTAuthenticationFilterTest {

    @Test
    void getMessageTest() {
        JWTAuthenticationFilter filter = new JWTAuthenticationFilter(null);
        Assertions.assertEquals("用户不存在", ReflectUtil.invoke(filter,
                "getMessage", new UsernameNotFoundException("")));
        Assertions.assertEquals("密码错误", ReflectUtil.invoke(filter,
                "getMessage", new BadCredentialsException("")));
    }
}
