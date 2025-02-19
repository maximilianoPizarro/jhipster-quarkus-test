package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.security.AuthoritiesConstants;
import org.junit.jupiter.api.Test;

public class AuthorityTest {

    @Test
    public void testAuthorityEquals() {
        var authorityA = new Authority();
        assertThat(authorityA).isEqualTo(authorityA);
        assertThat(authorityA).isNotEqualTo(null);
        assertThat(authorityA).isNotEqualTo(new Object());
        assertThat(authorityA.hashCode()).isEqualTo(0);
        assertThat(authorityA.toString()).isNotNull();

        var authorityB = new Authority();
        assertThat(authorityA).isEqualTo(authorityB);

        authorityB.name = AuthoritiesConstants.ADMIN;
        assertThat(authorityA).isNotEqualTo(authorityB);

        authorityA.name = AuthoritiesConstants.USER;
        assertThat(authorityA).isNotEqualTo(authorityB);

        authorityB.name = AuthoritiesConstants.USER;
        assertThat(authorityA).isEqualTo(authorityB);
        assertThat(authorityA.hashCode()).isEqualTo(authorityB.hashCode());
    }
}
