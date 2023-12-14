project(discount_applier-cmocka C)

add_cmocka_test(discount_applier_test
        SOURCES test-discount_applier.c
        LINK_LIBRARIES src cmocka-static)

add_cmocka_test_environment(discount_applier_test)

set_property(TARGET
        discount_applier_test
        PROPERTY
        LINK_FLAGS
        "${DEFAULT_LINK_FLAGS} -Wl,--wrap=notify_discount")

