package com.example.fetchrewards

import com.example.fetchrewards.service.FetchClient
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class FetchClientTest {
private val fetchApiClient = FetchClient();
@Test
fun get_information ()
{
   val information = fetchApiClient.api.getInformation().execute()
    assertNotNull(information.body()?.size)
}
}
