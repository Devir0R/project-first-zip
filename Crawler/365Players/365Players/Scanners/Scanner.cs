using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _365Players.Scanners
{
    public abstract class Scanner 
    {
        public const string SCANNER_EXCEPTION_POLICY = "Scanners";
        abstract public string Name { get; }
        public virtual ScannerStatus Status { get; private set; }
        private object SyncRoot { get; set; }
        public string Server { get; set; }

        public bool AsyncHandle { get; set; }


        public Scanner(int NumberOfAsyncHandlers = 1)
        {
            SyncRoot = new object();
        }

        public abstract void Start();
        public abstract void Stop();

        public abstract bool Scan();

        /// <summary>
        /// Scan the entities in the time range, one time
        /// </summary>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <returns></returns>
        public abstract bool Scan(DateTime start, DateTime end);

        public virtual bool Scan(DateTime start, DateTime end, TimeSpan waitBetweenDays)
        {
            bool bAnswer = true;

            try
            {
                while (start.Date <= end.Date)
                {
                    bAnswer = Scan(start, start) && bAnswer;

                    Thread.Sleep(waitBetweenDays);

                    start = start.AddDays(1);
                }
            }
            catch (Exception e)
            {
               
            }

            return bAnswer;
        }

        public virtual bool IsActive { get { return true; } }

        public bool HasErrors { get; private set; }

        public ICollection<string> Errors { get; private set; }

        protected virtual void SetHasErrors(bool hasErrors)
        {
            this.HasErrors = hasErrors;
            if (!hasErrors)
            {
                Errors = null;
            }
        }

        public virtual void RaiseEvent(ICollection<CPlayerUpdate> Updates)
        {
            
        }
        
    }

    public enum ScannerStatus
    {
        Idle,
        Running,
        ScanningOnce
    }

}
