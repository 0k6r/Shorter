package com.oku6er.shorter.model

import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.oku6er.shorter.ShorterApplication
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Class to raise the data context.
 * */
//TODO: Need fixed annotations or downgrade Spring version 1.3.*
@RunWith(SpringJUnit4ClassRunner::class)
@TestExecutionListeners(DbUnitTestExecutionListener::class)
@SpringBootTest(classes = [(ShorterApplication::class)])
@DirtiesContext
abstract class AbstractRepositoryTest : AbstractTransactionalJUnit4SpringContextTests()