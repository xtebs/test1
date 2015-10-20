package appening.test1.eventscreen;

import java.net.URI;

/**
 * Created by Ze on 22/09/2015.
 */
public abstract class ContentSource<ContentType>
{

    //persistent connections, single GETs, etc etc. No idea yet.

    public abstract ContentType load(URI uri);

}
